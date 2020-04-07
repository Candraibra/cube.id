import com.google.gson.annotations.SerializedName

data class CategoryResponse (

	@SerializedName("category") val category : List<Category>
)