package general.dev.orgaoapp.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Patient {

    @SerializedName("idPatient")
    @Expose
    var idPatient: Int? = null

    @SerializedName("idAdress")
    @Expose
    var idAdress: Int? = null

    @SerializedName("idOrgan")
    @Expose
    var idOrgan: Int? = null

    @SerializedName("namePatient")
    @Expose
    var namePatient: String? = null

    @SerializedName("rgPatient")
    @Expose
    var rgPatient: String? = null

    @SerializedName("cpfPatient")
    @Expose
    var cpfPatient: String? = null

    @SerializedName("phonePatient")
    @Expose
    var phonePatient: String? = null

    @SerializedName("emailPatient")
    @Expose
    var emailPatient: String? = null

    @SerializedName("passwordPatient")
    @Expose
    var passwordPatient: String? = null

    @SerializedName("genrePatient")
    @Expose
    var genrePatient: String? = null

    @SerializedName("birthdatePatient")
    @Expose
    var birthdatePatient: String? = null

    @SerializedName("heightPatient")
    @Expose
    var heightPatient: Double? = null

    @SerializedName("weightPatient")
    @Expose
    var weightPatient: Double? = null

    @SerializedName("bloodTypePatient")
    @Expose
    var bloodTypePatient: String? = null

    @SerializedName("dateCreatedPatient")
    @Expose
    var dateCreatedPatient: String? = null

    @SerializedName("dateUpdatedPatient")
    @Expose
    var dateUpdatedPatient: String? = null

    constructor(name: String?, rg: String?, cpf: String?, phone: String?, email: String?, password: String?, genre: String?, birhtday: String?, height: Double?, weight: Double?, blood: String?) {
        this.namePatient = name
        this.rgPatient = rg
        this.cpfPatient = cpf
        this.phonePatient = phone
        this.emailPatient = email
        this.passwordPatient = password
        this.genrePatient = genre
        this.birthdatePatient = birhtday
        this.heightPatient = height
        this.weightPatient = weight
        this.bloodTypePatient = blood
    }

}