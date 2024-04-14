@ApplicationModule(
        displayName = "Order Fulfillment",
        allowedDependencies = {
                "inventorymanagement",
                "common"
        }
)
package nl.daniel.dejong.orderfulfillment;

import org.springframework.modulith.ApplicationModule;