package ma.enset.billingservice.web;

import lombok.AllArgsConstructor;
import ma.enset.billingservice.config.BillingConfig;
import ma.enset.billingservice.config.VaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@AllArgsConstructor
public class ConfigServiceRestController {

    private final BillingConfig billingConfig;
    private BillingConfig myBillingConfig;
    private VaultConfig myVaultConfig;

//    @Value("${user.accessToken}")
//    private String accessToken;

    @GetMapping("/token")
    public String getAccessToken(){
        return billingConfig.getAccessToken();
    }

    @GetMapping("/vault")
    public String getVaultConfig(){
        return myVaultConfig.getUsername() + " " + myVaultConfig.getPassword();
    }
}
