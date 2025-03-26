public enum ObstacleType {
	Bonus, Crate, FallenTree, Stick, Stone;
	
	public String toString() {
		switch(this) {
			case Bonus: return "Bonus";
			case Crate: return "Crate";
			case FallenTree: return "FallenTree";
			case Stick: return "Stick";
			case Stone: return "Stone";
		}
		return null;
	}
}