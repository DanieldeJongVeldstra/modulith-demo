@ApplicationModule(
        displayName = "Order Fulfillment",
        allowedDependencies = {
                "common",
                "inventorymanagement",
        }
)
package nl.daniel.dejong.orderfulfillment;

import org.springframework.modulith.ApplicationModule;