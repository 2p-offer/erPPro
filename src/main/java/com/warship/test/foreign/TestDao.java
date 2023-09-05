package com.warship.test.foreign;

import com.alibaba.fastjson2.JSONArray;

public interface TestDao {
    TestRole getRole(long roleId);

    void saveData(JSONArray data);

    void delNameAge(int id);

}
