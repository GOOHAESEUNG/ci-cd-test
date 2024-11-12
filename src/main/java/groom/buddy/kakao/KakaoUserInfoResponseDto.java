// KakaoUserInfoResponseDto.java
package groom.buddy.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoUserInfoResponseDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class KakaoAccount {
        @JsonProperty("profile")
        private Profile profile;
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Profile {
        @JsonProperty("nickname")
        private String nickName;

        @JsonProperty("profile_image_url")
        private String profileImageUrl;
    }
}