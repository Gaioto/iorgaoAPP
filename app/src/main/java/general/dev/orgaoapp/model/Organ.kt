package general.dev.orgaoapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Organ {

    @SerializedName("idOrgan")
    @Expose
    var idOrgan: Int? = null

    @SerializedName("nameOrgan")
    @Expose
    var nameOrgan: String? = null

    @SerializedName("heightOrgan")
    @Expose
    var heightOrgan: Int? = null

    @SerializedName("weightOrgan")
    @Expose
    var weightOrgan: Int? = null

    @SerializedName("ageOrgan")
    @Expose
    var ageOrgan: Int? = null

    @SerializedName("genderOrgan")
    @Expose
    var genderOrgan: String? = null

    @SerializedName("conditionOrgan")
    @Expose
    var conditionOrgan: String? = null

    @SerializedName("descriptionOrgan")
    @Expose
    var descriptionOrgan: String? = null

}