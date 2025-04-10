public enum ObstacleType {
	BONUS, CRATE, FALLENTREE, MIRRORFALLENTREE, STICK, STONE;
	
	public String toString() {
		switch(this) {
			case BONUS: return "BonusItem";
			case CRATE: return "Crate";
			case FALLENTREE: return "FallenTree";
			case MIRRORFALLENTREE: return "MirroredFallenTree";
			case STICK: return "Stick";
			case STONE: return "Stone";
		}
		return null;
	}
}