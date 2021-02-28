package com.github.patsalyukas.client.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.patsalyukas.client.atm.ATM;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Getter
public class ATMConfigService {

    private static final String PATH_ATM_CONFIG = "/home/andrey/IdeaProjects/CheckBalance/ATMAplicationClient/src/main/resources/";
    private ATM atm;

    public ATMConfigService() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            atm = mapper.readValue(new File(PATH_ATM_CONFIG + "ATMConfig.yml"), ATM.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
