@ApplicationModule(
        displayName = "Inventory Management",
        allowedDependencies = {
                "common",
                //DEMO: Uncomment for choreography
                "orderfulfillment::product-order-events",
        }
)
package nl.daniel.dejong.inventorymanagement;

import org.springframework.modulith.ApplicationModule;