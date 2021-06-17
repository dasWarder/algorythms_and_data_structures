package com.example.testing.stack.brackets;

public enum BracketType {
    SQUARE("["),
    SQUARE_BACK("]"),
    ROUND("("),
    ROUND_BACK(")"),
    BRACE("{"),
    BRACE_BACK("}");


    private String type;

    BracketType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
