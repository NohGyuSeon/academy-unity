package com.daonplace.springbootweb.dto.user;

import com.daonplace.springbootweb.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDto {

    private int imageCount;
    private User user;
}
