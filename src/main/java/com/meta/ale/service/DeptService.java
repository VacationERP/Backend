package com.meta.ale.service;

import com.meta.ale.domain.DeptDto;

import java.util.List;

public interface DeptService {
    public DeptDto getByDeptName(String deptName);

    public DeptDto getByDeptId(Long deptId);

    List<DeptDto> getListDept();

    boolean updateDept(DeptDto deptDto);

    void insertDept(DeptDto deptDto);

    /* 부서의 잔여 TO 계산 */
    public Long calculateVcToByDept(Long userId) throws Exception;
}
