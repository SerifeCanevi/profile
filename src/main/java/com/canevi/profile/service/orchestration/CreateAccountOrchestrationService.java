package com.canevi.profile.service.orchestration;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.canevi.profile.domain.request.RequestCreateAccount;
import com.canevi.profile.domain.response.BaseResponse;
import com.canevi.profile.domain.response.ResponseAccount;
import com.canevi.profile.service.exception.AccountNotFoundException;
import com.canevi.profile.service.impl.AccountRelatedEmailServiceImpl;
import com.canevi.profile.service.intf.CreateAccountService;
import com.canevi.profile.util.generate.Token;
import com.canevi.profile.util.generate.TokenGenerator;
import com.canevi.profile.util.validator.AccountValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAccountOrchestrationService {
    private final TokenGenerator tokenGenerator;
    private final AccountValidator accountValidator;
    private final CreateAccountService createAccountService;
    private final AccountRelatedEmailServiceImpl accountRelatedEmailService;

    public ResponseAccount createAccount(RequestCreateAccount request) {
        ResponseAccount response = new ResponseAccount();
        try {
            accountValidator.validateAccountDTO(request.getAccount());
            response = createAccountService.createAccount(request);
            String token = tokenGenerator.generateToken(response.getAccount().getId());
            accountRelatedEmailService.createAccount(request.getAccount(), token);
        } catch (AccountNotFoundException e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }

    public BaseResponse validateAccount(String token) {
        BaseResponse response = new BaseResponse();
        try {
            Token tokenObj = tokenGenerator.decryptToken(token);
            response = createAccountService.validateAccount(tokenObj.getId(), tokenObj.getStartingDate());
        } catch (AccountNotFoundException e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }
}
