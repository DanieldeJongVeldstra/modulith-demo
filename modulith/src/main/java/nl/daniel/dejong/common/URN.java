package nl.daniel.dejong.common;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode
public abstract class URN<V> {
    @Getter
    @Setter
    protected V value;

    @Transient
    protected String namespace;
    public final static String URN_PREFIX = "urn:";

    public String toString() {
        return URN_PREFIX + namespace + ":" + value.toString();
    }
}
