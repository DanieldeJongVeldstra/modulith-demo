@ApplicationModule(
        displayName = "Order Fulfillment",
        allowedDependencies = {
                "common",
                //DEMO Comment for choreography
                "inventorymanagement",
        }
)
package nl.daniel.dejong.orderfulfillment;

import org.springframework.modulith.ApplicationModule;