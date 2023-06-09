package com.meta.ale.api;

import com.meta.ale.domain.Criteria;
import com.meta.ale.domain.GrantedVcDto;
import com.meta.ale.domain.UsePlanDto;
import com.meta.ale.domain.UserDto;
import com.meta.ale.service.UsePlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/useplan")
@Api(tags = "연차사용계획서",description = "연차 사용계획서 관련 api")
public class UsePlanRestController {

    private final UsePlanService usePlanService;

    @GetMapping
    @ApiOperation("연차사용")
    public Map<String, Object> getUsePlanList(@RequestParam(required = false, defaultValue = "all") String keyword,
                                              @AuthenticationPrincipal UserDto userDto,
                                              Criteria criteria) throws Exception {
        criteria.setKeyword(keyword);
        return usePlanService.getUsePlanList(criteria, userDto);
    }

    @GetMapping("/{plan_id}")
    public UsePlanDto getUsePlan(@PathVariable("plan_id") Long planId) throws Exception {
        return usePlanService.getUsePlanByPlanId(planId);
    }

    @PutMapping
    public ResponseEntity<?> modifyUsePlan(@RequestBody UsePlanDto usePlanDto) throws Exception {
        if (usePlanService.modifyUsePlan(usePlanDto)) {
            return ResponseEntity.ok().body("사용 계획이 수정되었습니다.");
        }
        return ResponseEntity.badRequest().body("잘못된 요청입니다.");
    }

    @PostMapping
    public ResponseEntity<?> addUsePlan(@RequestBody UsePlanDto usePlanDto) throws Exception {
        if (usePlanService.addUsePlan(usePlanDto)) {
            return ResponseEntity.ok().body("사용 계획이 추가되었습니다.");
        }
        return ResponseEntity.badRequest().body("잘못된 요청입니다.");
    }

    @PostMapping("/list")
    public ResponseEntity<?> addUsePlanList(@RequestBody List<UsePlanDto> usePlanDtoList) throws Exception {
        if(usePlanService.addUsePlanList(usePlanDtoList)){
            return ResponseEntity.ok().body("사용 계획 추가 완료");
        }
        return ResponseEntity.badRequest().body("잘못된 요청입니다.");
    }

    @GetMapping("/datelist/{docId}")
    public List<UsePlanDto> selectUserPlanListByDocId(@PathVariable("docId") Long docId){
        return usePlanService.selectUserPlanListByDocId(docId);
    }
}
