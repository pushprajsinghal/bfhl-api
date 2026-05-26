package com.bfhl.api.service.impl;

import com.bfhl.api.dto.BfhlRequest;
import com.bfhl.api.dto.BfhlResponse;
import com.bfhl.api.service.BfhlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String USER_ID = "pushpraj_singhal_05052005";
    private static final String EMAIL = "pushprajsinghal230787@acropolis.in";
    private static final String ROLL_NUMBER = "0827IT231107";

    @Override
    public BfhlResponse processRequest(BfhlRequest request) {
        if (request == null || request.getData() == null) {
            return new BfhlResponse(false, USER_ID, EMAIL, ROLL_NUMBER,
                    new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), "0", "");
        }

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        int sum = 0;
        StringBuilder concatAlphabets = new StringBuilder();

        for (String item : request.getData()) {
            if (item == null || item.isEmpty()) continue;

            if (isNumeric(item)) {
                int num = Integer.parseInt(item);
                sum += num;
                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            } else if (isAlphabetOnly(item)) {
                alphabets.add(item.toUpperCase());
                concatAlphabets.append(item);
            } else {
                specialCharacters.add(item);
            }
        }

        String concatString = buildConcatString(concatAlphabets.toString());

        return new BfhlResponse(true, USER_ID, EMAIL, ROLL_NUMBER,
                oddNumbers, evenNumbers, alphabets,
                specialCharacters, String.valueOf(sum), concatString);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isAlphabetOnly(String str) {
        if (str == null || str.isEmpty()) return false;
        return str.chars().allMatch(Character::isLetter);
    }

    private String buildConcatString(String input) {
        if (input == null || input.isEmpty()) return "";

        String reversed = new StringBuilder(input).reverse().toString();

        StringBuilder result = new StringBuilder();
        boolean makeUpper = true;

        for (char c : reversed.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(makeUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                makeUpper = !makeUpper;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
