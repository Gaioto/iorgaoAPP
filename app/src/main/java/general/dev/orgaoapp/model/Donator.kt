package general.dev.orgaoapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Donator {
    @SerializedName("idDonator")
    @Expose
    var idDonator: Int? = null

    @SerializedName("idAdress")
    @Expose
    var idAdress: Int? = null

    @SerializedName("idOrgan")
    @Expose
    var idOrgan: Int? = null

    @SerializedName("nameDonator")
    @Expose
    var nameDonator: String? = null

    @SerializedName("rgDonator")
    @Expose
    var rgDonator: String? = null

    @SerializedName("cpfDonator")
    @Expose
    var cpfDonator: String? = null

    @SerializedName("phoneDonator")
    @Expose
    var phoneDonator: String? = null

    @SerializedName("emailDonator")
    @Expose
    var emailDonator: String? = null

    @SerializedName("passwordDonator")
    @Expose
    var passwordDonator: String? = null

    @SerializedName("genreDonator")
    @Expose
    var genreDonator: String? = null

    @SerializedName("birthdateDonator")
    @Expose
    var birthdateDonator: String? = null

    @SerializedName("heightDonator")
    @Expose
    var heightDonator: Double? = null

    @SerializedName("weightDonator")
    @Expose
    var weightDonator: Double? = null

    @SerializedName("bloodTypeDonator")
    @Expose
    var bloodTypeDonator: String? = null

    @SerializedName("dateCreatedDonator")
    @Expose
    var dateCreatedDonator: String? = null

    @SerializedName("dateUpdatedDonator")
    @Expose
    var dateUpdatedDonator: String? = null


    constructor(name: String?, rg: String?, cpf: String?, phone: String?, email: String?, password: String?, genre: String?, birhtday: String?, height: Double?, weight: Double?, blood: String?) {
        this.nameDonator = name
        this.rgDonator = rg
        this.cpfDonator = cpf
        this.phoneDonator = phone
        this.emailDonator = email
        this.passwordDonator = password
        this.genreDonator = genre
        this.birthdateDonator = birhtday
        this.heightDonator = height
        this.weightDonator = weight
        this.bloodTypeDonator = blood
    }

}