package com.example.testing.stack.brackets;

import java.util.List;
import java.util.Optional;

public class BracketChecker {

    private CharStack charStack;


    public boolean isBracketsAreCorrect(String toCheck) {

        charStack = new CharStack(toCheck.length());

        for(int i = 0; i < toCheck.length(); i++) {

            boolean isValid = validateBracketOrAddItToStack(
                                                 toCheck.charAt(i));

            if(!isValid) {
                return false;
            }
        }

        return true;
    }

    private boolean validateBracketOrAddItToStack(char element) {

        String stringElement = String.valueOf(element);

        if(isBracket(stringElement)) {

            charStack.push(element);

        } else if (isBackBracket(stringElement)) {

            return validationBackwardBracket(stringElement);

        }

        return true;
    }


    private boolean isBracket(String element) {
        List<BracketType> brackets = List.of(
                                            BracketType.BRACE,
                                            BracketType.SQUARE,
                                            BracketType.ROUND);

        return checkEqualsTypeOfBracket(brackets, element);
    }


    private boolean isBackBracket(String element) {
        List<BracketType> backBrackets = List.of(
                                                BracketType.SQUARE_BACK,
                                                BracketType.ROUND_BACK,
                                                BracketType.BRACE_BACK);

        return checkEqualsTypeOfBracket(backBrackets, element);
    }


    private boolean checkEqualsTypeOfBracket(List<BracketType> brackets, String element) {

        Optional<BracketType> possibleBackBracket = brackets.stream()
                                                                .filter(bracket ->
                                                                        bracket.getType().equals(element))
                                                                .findFirst();

        return checkOptional(possibleBackBracket);
    }


    private boolean checkOptional(Optional<BracketType> possibleBracket) {

        return possibleBracket.isPresent();
    }


    private boolean validationBackwardBracket(String elementToValidate) {

        if (!charStack.isEmpty()) {

            char topBracketFromStack = charStack.pop();
            String bracketToString = String.valueOf(topBracketFromStack);

            boolean correlated = correlationOfStackAndOuterBracket(bracketToString, elementToValidate);

            return correlated;

        } else {
            return false;
        }
    }


    private boolean correlationOfStackAndOuterBracket(String stackBracket, String outerBracket) {

        List<BracketType> brackets = List.of(
                BracketType.BRACE,
                BracketType.SQUARE,
                BracketType.ROUND);

        for(BracketType bracketType : brackets) {

            BracketType backwardType = getBackwardTypeForBracket(bracketType);

            if (stackBracket.equals(bracketType.getType()) && !outerBracket.equals(backwardType.getType())) {

                return false;
            }
        }

        return true;
    }


    private BracketType getBackwardTypeForBracket(BracketType bracketType) {

        BracketType backwardType = null;

        switch (bracketType) {
            case BRACE -> {
                backwardType = BracketType.BRACE_BACK;
                break;
            }
            case SQUARE -> {
                backwardType = BracketType.SQUARE_BACK;
                break;
            }
            case ROUND -> {
                backwardType = BracketType.ROUND_BACK;
                break;
            }
        }

        return backwardType;
    }

}
