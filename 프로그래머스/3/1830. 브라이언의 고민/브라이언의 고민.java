import java.util.*;
class Solution {
    static char[] sentence;
	
	static class Word{
		int rule, start, end;
		
		public Word(int rule, int start, int end) {
			this.rule = rule;
			this.start = start;
			this.end = end;
		}
	}
    
    public String solution(String s) {    
        sentence = s.toCharArray();
        
        String invalid = "invalid";
        
        LinkedHashMap<Character, List<Integer>> chars = new LinkedHashMap<>();
        int len = s.length(), i; char c;
        for(i = 0; i < len; i++) {
        	c = sentence[i];
        	
        	if(c >= 'a' && c <= 'z') {
        		if(!chars.containsKey(c))
        			chars.put(c,  new ArrayList<>());
        		chars.get(c).add(i);
        	}
        }
        
        List<Word> words = new ArrayList<>();
        int start_str = 0,
        	start_char, end_char, start_char_pre = -1, end_char_pre = -1,
        	start_word = 0, end_word = 0, end_word_pre = -1,
        	num, rule = -1, distance; boolean isDistance2;
        for(List<Integer> positions : chars.values()) {
        	num = positions.size();
        	start_word = start_char = positions.get(0);
        	end_word = end_char = positions.get(num - 1);
        	isDistance2 = true;
        	
        	for(i = 1; i < num; i++) {
        		distance = positions.get(i) - positions.get(i - 1);
        		if(distance < 2) return invalid;
        		if(distance > 2) {
        			isDistance2 = false;
        			break;
        		}
        	}
        	
        	if(num >= 3 && !isDistance2) return invalid;
        	if(num == 1 || num >= 3) {
        		rule = 1;
        		start_word--;
        		end_word++;
        		if(start_word < 0 || len <= end_word) return invalid;        		
        	}
        	
        	if(num == 2)
        		rule = isDistance2 ? 0 : 2;
        	if(start_char_pre < start_char && end_char < end_char_pre) {
        		if(rule == 2) return invalid;
        		continue;
        	}
        	if(end_word_pre >= start_word) return invalid;
        	words.add(new Word(rule, start_word, end_word));
        	start_char_pre = start_char;
        	end_char_pre = end_char;
        	end_word_pre = end_word;
        }    
        StringBuilder answer = new StringBuilder();
        int size = words.size(); Word word;
        for(i = 0; i < size; ++i) {
        	word = words.get(i);
        	rule = word.rule;
        	start_word = word.start;
        	end_word = word.end;
        	if(rule == 0) {
        		if((start_str <= start_word - 1) && (end_word + 1 < (i < size - 1 ? words.get(i + 1).start : len))) {
        			start_word--;
        			end_word++;
        		}
        	}
        	if(start_str < start_word)
        		answer.append(getStr(start_str, start_word - 1));
        	answer.append(getStr(start_word, end_word));
        	start_str = end_word + 1;
        }
        if(start_str < len)
        	answer.append(getStr(start_str, len - 1));
        return answer.toString().trim();
    }
    
    public String getStr(int start, int end) {
    	StringBuilder str = new StringBuilder(); char c;
    	for(int i = start; i <= end; ++i) {
    		c = sentence[i];
    		if(c >= 'A' && c <= 'Z')
    			str.append(c);
    	}
    	return str.toString() + " ";
    }
}