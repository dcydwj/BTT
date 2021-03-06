package cn.jag.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zhangjie
 */
public class Bird extends Mover {

	private int turnBackCnt; // 折返次数

	private float distance = 0f; // 飞过的距离

	public Bird(String name, float speed, float position, Direction direction, CyclicBarrier cyclicBarrier) {
		super(name, speed, position, direction, cyclicBarrier);
	}

	@Override
	public void move(long time) {
		super.move(time);
		distance += speed * time;
	}

	public void turnBack() {
		if (direction == Direction.LEFT) {
			direction = Direction.RIGHT;
		} else {
			direction = Direction.LEFT;
		}
		turnBackCnt++;
	}

	public int getTurnBackCnt() {
		return turnBackCnt;
	}

	public float getDistance() {
		return distance;
	}
}
