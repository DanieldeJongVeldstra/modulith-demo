@ApplicationModule(
        displayName = "Inventory Management",
        allowedDependencies = {
                "common",
                //DEMO: Uncomment for choreography
                //"orderfulfillment",
        }
)
package nl.daniel.dejong.inventorymanagement;

import org.springframework.modulith.ApplicationModule;