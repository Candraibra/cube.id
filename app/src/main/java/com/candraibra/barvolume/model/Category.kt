import com.google.gson.annotations.SerializedName


data class Category (

	@SerializedName("name") val name : String,
	@SerializedName("image") val image : String
)