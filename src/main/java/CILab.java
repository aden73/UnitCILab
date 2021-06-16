public class CILab implements CILabInterface {
    private String myString;

    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public boolean detectCapitalUse() {
        if (myString.isEmpty()) {
            return true;
        }
        for (var word : myString.split("\\s+")) {
            if (!(word.codePoints().allMatch(Character::isUpperCase) || word.codePoints().allMatch(
                    Character::isLowerCase))) {
                if (word.length() == 0) {
                    continue;
                }
                var characters = word.codePoints().toArray();
                if (!Character.isUpperCase(characters[0])) {
                    return false;
                }
                for (int i = 1; i < characters.length; ++i) {
                    if (Character.isUpperCase(characters[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}

