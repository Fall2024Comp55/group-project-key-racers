public enum ObstacleType {
	BONUS, CRATE, FALLENTREE, STICK, STONE;
	
	public String toString() {
		switch(this) {
			case BONUS: return "Bonus";
			case CRATE: return "Crate";
			case FALLENTREE: return "FallenTree";
			case STICK: return "Stick";
			case STONE: return "Stone";
		}
		return null;
	}
}