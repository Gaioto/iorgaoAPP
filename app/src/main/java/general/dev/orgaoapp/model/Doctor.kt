package general.dev.orgaoapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Doctor {

    @SerializedName("idDoctor")
    @Expose
    val idDoctor: Int? = null

    @SerializedName("idPatient")
    @Expose
    val idPatient: Int? = null

    @SerializedName("crmDoctor")
    @Expose
    val crmDoctor: Int? = null

    @SerializedName("emailDoctor")
    @Expose
    val emailDoctor: String? = null

    @SerializedName("passwordDoctor")
    @Expose
    val passwordDoctor: String? = null

    @SerializedName("nameDoctor")
    @Expose
    val nameDoctor: String? = null

    @SerializedName("rgDoctor")
    @Expose
    val rgDoctor: String? = null

    @SerializedName("phoneDoctor")
    @Expose
    val phoneDoctor: String? = null

    @SerializedName("dateCreatedDoctor")
    @Expose
    val dateCreatedDoctor: String? = null

    @SerializedName("dateUpdatedDoctor")
    @Expose
    val dateUpdatedDoctor: String? = null
}