package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.Embeddable

@Embeddable
data class Address(

        var country: String,
        var city: String,
        var street: String,
        var buildingNumber: String,
        var apartmentNumber: String?,
        var postalCode: String

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            country = "",
            city = "",
            street = "",
            buildingNumber = "",
            apartmentNumber = "",
            postalCode = ""
    )

}