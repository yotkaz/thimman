package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.Embeddable

@Embeddable
data class Address(

        var country: String,
        var city: String,
        var street: String,
        var buildingNumber: String,
        var apartmentNumber: String,
        var postalCode: String

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            country = DEFAULT_STRING,
            city = DEFAULT_STRING,
            street = DEFAULT_STRING,
            buildingNumber = DEFAULT_STRING,
            apartmentNumber = DEFAULT_STRING,
            postalCode = DEFAULT_STRING
    )

}