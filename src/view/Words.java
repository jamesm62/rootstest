package view;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Words {
	private String root;

	String[][] array = {
			{ "biblio", "book" },
			{ "dict", "word" },
			{ "script", "write/draw", "draw/write", "write", "draw" },
			{ "juv", "youth" },
			{ "-ous", "makes an adjective", "makes adjective", "makes an adj",
					"makes adj", "adjective", "adj", "make an adjective",
					"make adjective", "make an adj", "make adj",
					"makes a adjective", "makes adjective", "makes a adj",
					"makes adj", "adjective", "adj", "make a adjective",
					"make adjective", "make a adj", "make adj" },
			{ "contra", "against" },
			{ "fide", "faith/trust", "faith", "trust", "trust/faith" },
			{ "-ful", "makes an adjective", "makes adjective", "makes an adj",
					"makes adj", "adjective", "adj", "make an adjective",
					"make adjective", "make an adj", "make adj",
					"makes a adjective", "makes adjective", "makes a adj",
					"makes adj", "adjective", "adj", "make a adjective",
					"make adjective", "make a adj", "make adj" },
			{ "bio", "life", "live", "life/live", "live/life" },
			{ "phil", "love" },
			{ "-able/-ible", "makes an adjective", "makes adjective",
					"makes an adj", "makes adj", "adjective", "adj",
					"make an adjective", "make adjective", "make an adj",
					"make adj", "makes a adjective", "makes adjective",
					"makes a adj", "makes adj", "adjective", "adj",
					"make a adjective", "make adjective", "make a adj",
					"make adj" },
			{ "cede", "move/withdraw", "move", "withdraw", "withdraw/move" },
			{ "scop", "look/see/examine", "look/examine/see",
					"see/look/examine", "see/examine/look", "examine/look/see",
					"examine/see/look", "look", "see", "examine" },
			{ "chron", "time" },
			{ "meter", "measure" },
			{ "centi", "one hundred", "hundred", "one-hundred", "one-hun",
					"one hun", "hun", "100" },
			{ "mil", "one thousand", "thousand", "one-thousand", "one-thou",
					"one thou", "thou", "1000" },
			{ "kilo", "one thousand", "thousand", "one-thousand", "one-thou",
					"one thou", "thou", "1000" },
			{ "-ment", "makes a noun", "makes noun", "makes an n", "makes n",
					"noun", "n", "make an noun", "make noun", "make an n",
					"make n", "makes an noun", "makes noun", "makes a n",
					"makes n", "noun", "n", "make a noun", "make noun",
					"make a n", "make n" },
			{ "phys", "nature/growth", "growth/nature", "grow/natural",
					"natural/grow", "nature/grow", "grow/nature",
					"growth/natural", "natural/growth", "growth", "nature",
					"grow", "natural" },
			{ "pyr", "fire" },
			{ "grat", "please", "pleased" },
			{ "-ity", "makes a noun", "makes noun", "makes an n", "makes n",
					"noun", "n", "make an noun", "make noun", "make an n",
					"make n", "makes an noun", "makes noun", "makes a n",
					"makes n", "noun", "n", "make a noun", "make noun",
					"make a n", "make n" },
			{ "-ize", "makes an verb", "makes verb", "makes an v", "makes v",
					"verb", "v", "make an verb", "make verb", "make an v",
					"make v", "makes a verb", "makes verb", "makes a v",
					"makes v", "verb", "v", "make a verb", "make verb",
					"make a v", "make v" },
			{ "cyclo", "circle", "circular" },
			{ "graph/gram", "write/draw", "draw/write", "draw", "write" },
			{ "-ence", "makes a noun", "makes noun", "makes an n", "makes n",
					"noun", "n", "make an noun", "make noun", "make an n",
					"make n", "makes an noun", "makes noun", "makes a n",
					"makes n", "noun", "n", "make a noun", "make noun",
					"make a n", "make n" },
			{ "demos", "people", "person" },
			{ "pro", "before" },
			{ "cert", "true", "truth" },
			{ "audio", "sound" },
			{ "anthrop", "mankind", "humankind", "man", "human", "humans" },
			{ "-ary", "makes an adjective", "makes adjective", "makes an adj",
					"makes adj", "adjective", "adj", "make an adjective",
					"make adjective", "make an adj", "make adj",
					"makes a adjective", "makes adjective", "makes a adj",
					"makes adj", "adjective", "adj", "make a adjective",
					"make adjective", "make a adj", "make adj" },
			{ "-ology", "the study of", "study of", "study", "the study" },
			{ "miso", "hate", "dislike", "hated" },
			{ "-ish", "makes an adjective", "makes adjective", "makes an adj",
					"makes adj", "adjective", "adj", "make an adjective",
					"make adjective", "make an adj", "make adj",
					"makes a adjective", "makes adjective", "makes a adj",
					"makes adj", "adjective", "adj", "make a adjective",
					"make adjective", "make a adj", "make adj" },
			{ "-ate", "makes an verb", "makes verb", "makes an v", "makes v",
					"verb", "v", "make an verb", "make verb", "make an v",
					"make v", "makes a verb", "makes verb", "makes a v",
					"makes v", "verb", "v", "make a verb", "make verb",
					"make a v", "make v" },
			{ "alt", "high/height", "high", "height", "height/high" },
			{ "deci", "ten", "10", "tenth" },
			{ "geo", "earth", "planet", "planet earth" },
			{ "peri", "through/around", "around/through", "through", "around" },
			{ "-al", "makes an adjective", "makes adjective", "makes an adj",
					"makes adj", "adjective", "adj", "make an adjective",
					"make adjective", "make an adj", "make adj",
					"makes a adjective", "makes adjective", "makes a adj",
					"makes adj", "adjective", "adj", "make a adjective",
					"make adjective", "make a adj", "make adj" },
			{ "theo", "god", "godly", "theology" },
			{ "psych", "mind", "brain", "think", "know" },
			{ "-er", "makes a noun", "makes noun", "makes an n", "makes n",
					"noun", "n", "make an noun", "make noun", "make an n",
					"make n", "makes an noun", "makes noun", "makes a n",
					"makes n", "noun", "n", "make a noun", "make noun",
					"make a n", "make n" },
			{ "-ist", "makes a person", "person", "p", "makes person" },
			{ "-ive", "makes an adjective" },
			{ "ante", "before", "pre" },
			{ "anti", "against", "un supporting", "un-supporting",
					"not supporting" },
			{ "bi", "two", "2" },
			{ "circum", "around", "circumference" },
			{ "com", "together", "grouped", "joined", "group", "join" },
			{ "con", "together", "grouped", "joined", "group", "join" },
			{ "de", "down", "below" },
			{ "dis", "away", "far", "distant" },
			{ "equi", "equal", "equivalent" },
			{ "extra", "beyond", "far", "distant", "away" },
			{ "inter", "between" },
			{ "intra", "within", "in" },
			{ "intro", "into", "in", "to" },
			{ "mal", "bad", "not good" },
			{ "mis", "bad", "not good" },
			{ "non", "not", "no" },
			{ "post", "after", "later" },
			{ "pre", "before", "pre" },
			{ "semi", "half", "some" },
			{ "sub", "under", "underneath", "below", "beneath", "down" },
			{ "super", "above", "top", "on top", "on-top", "on" },
			{ "syn", "together", "grouped", "group", "joined", "join" },
			{ "tri", "three", "3", "thrice", "3 times", "three times", "triple" },
			{ "un", "not", "no" },
			{ "archy", "government", "gov", "govern" },
			{ "ard", "always", "most of the time" },
			{ "cide", "kill", "homocide", "dead", "die" },
			{ "ician", "specialist", "professional" },
			{ "aqua", "water", "hydro" },
			{ "audi", "hear", "listen" },
			{ "bell", "war", "battle", "conflict", "struggle", "skirmish",
					"fight" },
			{ "cap", "take", "take away", "away" },
			{ "cise", "cut", "scissors", "scissor" },
			{ "auto", "self", "oneself", "one" },
			{ "port", "carry", "hold", "transport", "take" },
			{ "scrib", "write", "jot down", "jot", "scribble" },
			{ "logy", "science", "physics", "chemistry", "biology" },
			{ "cred", "believe", "think", "true", "truth" },
			{ "neo", "new" },
			{ "ad", "to", "do" },
			{ "miss", "send", "sent", "dismiss" },
			{ "centri", "center", "middle", "mid", "mid-point" },
			{ "homo", "same", "uniform", "unvarying" },
			{ "spect", "look", "look/see/examine", "look/examine/see",
					"see/look/examine", "see/examine/look", "examine/look/see",
					"examine/see/look", "see", "examine" },
			{ "duct", "lead", "metal", "conduct", "electricity", "electric" },
			{ "fer", "carry", "transport", "hold", "take" },
			{ "pend", "hang/weigh/pay", "hang/pay/weigh", "weigh/hang/pay",
					"weigh/pay/hang", "pay/weigh/hang", "pay/hang/weigh",
					"hang", "weigh", "pay", "weight", "compensate" },
			{ "micro", "small", "tiny" },
			{ "hydro", "water", "aquatic", "aqua" },
			{ "photo", "light", "bright", "lighted", "lighting" },
			{ "pan", "all", "omni", "ominous", "every", "most" },
			{ "penta", "five", "5", "fifth" },
			{ "tele", "far/distant", "distant/far", "far", "distant" },
			{ "vid", "look", "look/see/examine", "look/examine/see",
					"see/look/examine", "see/examine/look", "examine/look/see",
					"examine/see/look", "see", "examine" },
			{ "omni", "all", "every", "pan" },
			{ "ex", "out", "away" },
			{ "poly", "many", "all", "most", "alot", "a lot", "a-lot" },
			{ "re", "again", "repeat" },
			{ "hypo", "under", "underneath", "beneath", "bottom", "below" },
			{ "pseudo", "false", "untrue", "not true", "not-true" },
			{ "neuro", "nerve", "nervous", "nerves", "nervous system" },
			{ "-tomy", "cut", "sliced", "diced", "slice", "dice" },
			{ "hema", "blood", "sangui", "red liquid" },
			{ "proto", "first", "new", "one", "1" },
			{ "phon", "sound", "audio", "hear", "listen" },
			{ "mono", "one", "1", "first" },
			{ "viv", "life", "live" },
			{ "morph", "shape", "contour", "perimeter", "change" },
			{ "vest", "clothes", "clothe", "cloth", "wear", "garb", "garments" },
			{ "bene", "good/well", "good", "well", "well/good" },
			{ "pond", "weight", "weigh" },
			{ "corp", "body", "corpse" },
			{ "dorm", "sleep", "dormitory" },
			{ "nov", "new", "novice" },
			{ "punct", "point", "sharp", "poky" },
			{ "ject", "throw", "threw", "hurl", "chuck" },
			{ "-tion", "act/state", "act", "state", "state/act" },
			{ "loco", "place", "location", "destination" },
			{ "dox", "opinion", "thought", "position" },
			{ "amphi", "both", "two", "2", "second" },
			{ "magna", "great", "large", "big", "magnitude" },
			{ "eu", "good", "well", "good/well", "well/good", "great",
					"awesome" }, { "endo", "within", "in", "inside" },
			{ "phobia", "fear", "fright", "frightened" },
			{ "ortho", "straight" },
			{ "put", "think", "mind", "know", "brain" },
			{ "ver", "truth", "true", "not false" },
			{ "matri", "mother", "mom", "Mom", "Mother" },
			{ "mega", "large", "big", "voluminous" },
			{ "pop", "people", "population", "person" },
			{ "sangui", "blood", "liquid" },
			{ "pater", "father", "dad", "Dad", "Father", },
			{ "vita", "life", "live", "lived", "living" },
			{ "demo", "people", "person", "population" },
			{ "stereo", "solid", "sound" }, { "ism", "doctrine" },
			{ "cogn", "know", "mind", "think", "brain" },
			{ "sur", "over", "top", "above", "up" },
			{ "alter", "other", "alternative" },
			{ "astr", "star", "stellar", "sun" },
			{ "dyna", "power", "strength", "potent", "potence" },
			{ "hyper", "over", "up", "above", "more" },
			{ "luna", "moon", "lunatic", "lunar" },
			{ "octa", "eight", "octagon", "8", "eighth" },
			{ "gyro", "turn", "gear" }, { "amat", "love", "feeling" },
			{ "helio", "sun", "star", "stellar" },
			{ "tetra", "four", "4", "fourth" }, { "son", "sound", "audio" },
			{ "dec", "ten", "10", "tenth" },
			{ "stell", "star", "stellar", "sun" } };

	private static int getRandom() {
		Random random = new Random();
		int rand = random.nextInt(158);

		return rand;
	}

	private void setStats(String root) {
		this.root = root;
	}

	void setRoot() {
		int random = getRandom();
		setRoot(array[random][0]);
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String[][] getArray() {
		return array;
	}

	public Set<String> getDefForRoot(String root) {
		Set<String> defs = new LinkedHashSet<String>();
		boolean foundRoot = false;
		int i = 0;
		int rootIndex = 0;

		while (!(foundRoot)) {
			if (array[i][0] == root) {
				foundRoot = true;
				rootIndex = i;
			}
			i++;
		}

		for (int a = 1; a != (array[rootIndex].length); a++) {
			defs.add(array[rootIndex][a]);
		}

		return defs;
	}

	public List<String> getDefForRootList(String root) {
		List<String> defs = new LinkedList<String>();
		boolean foundRoot = false;
		int i = 0;
		int rootIndex = 0;

		while (!(foundRoot)) {
			if (array[i][0] == root) {
				foundRoot = true;
				rootIndex = i;
			}
			i++;
		}

		for (int a = 1; a != (array[rootIndex].length); a++) {
			defs.add(array[rootIndex][a]);
		}

		return defs;
	}
}
