package general.dev.orgaoapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Donation {

    @SerializedName("idDonation")
    @Expose
    val idDonation: Int? = null

    @SerializedName("idDonator")
    @Expose
    val idDonator: Int? = null

    @SerializedName("idPatient")
    @Expose
    val idPatient: Int? = null

    @SerializedName("idDoctor")
    @Expose
    val idDoctor: Int? = null

    @SerializedName("dsDonation")
    @Expose
    val dsDonation: String? = null

    @SerializedName("dateCreatedDonation")
    @Expose
    val dateCreatedDonation: String? = null

    @SerializedName("dateUpdatedDonation")
    @Expose
    val dateUpdatedDonation: String? = null

}