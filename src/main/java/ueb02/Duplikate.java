package ueb02;

class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen..
	 */
	static StringSet findeDuplikate(String text) {
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			if (Character.isAlphabetic(c) || c == ' ')
				sb.append(c);
		}
		text = sb.toString();

		StringSet s1 = new StringSetImpl();
		StringSet s2 = new StringSetImpl();

		//Kennt das erste Set das Wort bereits, so tritt es zum zweiten Mal auf!
		for (String w : text.split(" ")) {
			if (s1.contains(w))
				s2.add(w);


		//Jedes Wort in das erste Set einfügen
		s1.add(w);
	}
	return s2;
	}
}
