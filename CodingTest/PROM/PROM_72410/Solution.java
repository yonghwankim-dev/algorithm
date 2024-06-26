package PROM.PROM_72410;

class Solution {

    public static boolean isNotMoreThanTwoLength(String text){
        return text.length() <= 2;
    }

    public static String appendLastCharacterUntilThreeLength(String text){
        if(!isNotMoreThanTwoLength(text))
        {
            return text;
        }
        char last_ch = text.charAt(text.length()-1);
        while(isNotMoreThanTwoLength(text))
        {
            text += last_ch;
        }
        return text;
    }

    public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();                                  // 1단계, 모든 대문자를 소문자로 변환
        new_id = new_id.replaceAll("[^\\w-_.]","");     // 2단계  알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
        new_id = new_id.replaceAll("\\.{2,}", ".");     // 3단계  new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = new_id.replaceAll("^\\.|\\.$", "");    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다
        new_id = new_id.equals("") ? "a" : new_id;                      // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        // 6단계
        // new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        new_id = new_id.length()>=16 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.replaceAll("\\.$", "");
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        new_id = appendLastCharacterUntilThreeLength(new_id);
        answer = new_id;

        return answer;
    }
}
