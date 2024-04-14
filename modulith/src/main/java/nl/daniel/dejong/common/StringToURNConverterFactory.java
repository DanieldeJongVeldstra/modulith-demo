package nl.daniel.dejong.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

@Component
public class StringToURNConverterFactory implements ConverterFactory<String, URN<?>> {

    @Override
    public <T extends URN<?>> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToURNConverter<>(targetType);
    }

    private static class StringToURNConverter<T extends URN> implements org.springframework.core.convert.converter.Converter<String, T> {

        private final Class<T> targetType;

        public StringToURNConverter(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            try {
                var valueType = getValueTypeFromURN(targetType);
                var urnValue = getURNValue(source, valueType);

                return targetType.getConstructor(valueType).newInstance(urnValue);
            } catch (Exception e) {
                throw new IllegalArgumentException("Could not convert " + source + " to " + targetType.getName(), e);
            }
        }

        private Class<?> getValueTypeFromURN(Class<T> targetType) {
            return (Class<?>) ((ParameterizedType)targetType.getGenericSuperclass()).getActualTypeArguments()[0];
        }

        private <V> V getURNValue(String source, Class<V> valueType) {
            var splitURN = source.split(":");
            var sourceWithoutUrnValues = splitURN[splitURN.length - 1];

            return valueType.cast(sourceWithoutUrnValues);
        }
    }
}
