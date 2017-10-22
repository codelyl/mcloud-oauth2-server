package me.javaroad.oauth.controller.api;

import static me.javaroad.oauth.controller.OAuthConstants.API_PREFIX;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import me.javaroad.oauth.dto.request.ApprovalRequest;
import me.javaroad.oauth.dto.response.ApprovalResponse;
import me.javaroad.oauth.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping(API_PREFIX + "/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    @Autowired
    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @ApiOperation(value = "Create Approval", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApprovalResponse createApproval(@RequestBody @Valid ApprovalRequest approvalRequest) {
        return approvalService.createApproval(approvalRequest);
    }

    @ApiOperation(value = "Get All Approval", httpMethod = "GET")
    @GetMapping
    public List<ApprovalResponse> getAllApproval() {
        return approvalService.getAll();
    }


}