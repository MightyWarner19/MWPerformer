package com.Mighty.Performance.service;

import com.Mighty.Performance.dto.UserDto;
import com.Mighty.Performance.entity.User;

public interface UserService {
    User save(UserDto userDto);
}
