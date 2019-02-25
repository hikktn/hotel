package com.lisonglin.daomain;

public class RoomTitle {
	private int id;
	private Locals local;
	private RoomLevel level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Locals getLocal() {
		return local;
	}

	public void setLocal(Locals local) {
		this.local = local;
	}

	public RoomLevel getLevel() {
		return level;
	}

	public void setLevel(RoomLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "RoomTitle [id=" + id +", level=" + level + ", local=" + local +  "]";
	}

}
