package general.dev.orgaoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Adress {

    @SerializedName("idAdress")
    @Expose
    val idAdress: Int? = null

    @SerializedName("streetAdress")
    @Expose
    var streetAdress: String? = null

    @SerializedName("numberAdress")
    @Expose
    var numberAdress: Int? = null

    @SerializedName("complementAdress")
    @Expose
    var complementAdress: String? = null

    @SerializedName("cityAdress")
    @Expose
    var cityAdress: String? = null

    @SerializedName("zipcodeAdress")
    @Expose
    var zipcodeAdress: String? = null

    @SerializedName("stateAdress")
    @Expose
    var stateAdress: String? = null

    @SerializedName("dateCreatedAdress")
    @Expose
    var dateCreatedAdress: String? = null

    @SerializedName("dateUpdatedAdress")
    @Expose
    var dateUpdatedAdress: String? = null

    constructor(street : String, number : Int, complement : String, city : String, zipcode : String, state : String) {
        this.streetAdress = street
        this.numberAdress = number
        this.complementAdress = complement
        this.cityAdress = city
        this.zipcodeAdress = zipcode
        this.stateAdress = state
    }

}
