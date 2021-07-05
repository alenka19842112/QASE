package objects;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuite {
    String title;
    @SerializedName("parent_id")
    String parentId;
    String description;
    String preconditions;
}

