/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.core.geom;

import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.util.EdgeIterator;

import com.badlogic.gdx.math.Vector2;

/**
 * Base class for shapes
 */
public abstract class Shape {
	/**
	 * Returns an exact copy of this {@link Shape}
	 * @return A copy (new) instance of this {@link Shape}
	 */
	public abstract Shape copy();

	/**
	 * Returns if a set of coordinates are contained inside this {@link Shape}
	 * 
	 * @param x
	 *            The x coordinate to check
	 * @param y
	 *            The y coordinate to check
	 * @return True if this {@link Shape} contains the specified coordinates
	 */
	public abstract boolean contains(float x, float y);

	/**
	 * Returns if a {@link Vector2} is contained inside this {@link Shape}
	 * 
	 * @param vector2
	 *            The {@link Vector2} to check
	 * @return True if this {@link Shape} contains the specified {@link Vector2}
	 */
	public abstract boolean contains(Vector2 vector2);
	
	/**
	 * Returns if a {@link Shape} is contained inside this {@link Shape}
	 * @param shape The {@link Shape} to check
	 * @return True if this {@link Shape} contains the specified {@link Shape}
	 */
	public abstract boolean contains(Shape shape);

	/**
	 * Returns if this {@link Shape} intersects the specified
	 * {@link LineSegment}
	 * 
	 * @param lineSegment
	 *            The {@link LineSegment} to check
	 * @return True if this {@link Shape} intersects the {@link LineSegment}
	 */
	public boolean intersects(LineSegment lineSegment) {
		return intersectsLineSegment(lineSegment.getPointA(), lineSegment.getPointB());
	}

	/**
	 * Returns if this {@link Shape} intersects a line segment
	 * 
	 * @param pointA
	 *            The first point in the line segment
	 * @param pointB
	 *            The second point in the line segment
	 * @return True if this {@link Shape} intersects the line segment
	 */
	public abstract boolean intersectsLineSegment(Vector2 pointA, Vector2 pointB);
	
	/**
	 * Returns if this {@link Shape} intersects a line segment
	 * 
	 * @param x1 The x coordinate of the first point
	 * @param y1 The y coordinate of the first point
	 * @param x2 The x coordinate of the second point
	 * @param y2 The y coordinate of the second point
	 * @return True if this {@link Shape} intersects the line segment
	 */
	public abstract boolean intersectsLineSegment(float x1, float y1, float x2, float y2);
	
	/**
	 * Returns if this {@link Shape} intersects another {@link Shape}
	 * @param shape The {@link Shape} to check
	 * @return True if this {@link Shape} intersects the specified {@link Shape}
	 */
	public abstract boolean intersects(Shape shape);
	
	/**
	 * Returns the distance from this {@link Shape} to a set of coordinates
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The distance
	 */
	public abstract float getDistanceTo(float x, float y);
	
	/**
	 * Returns the rotation of this {@link Shape}
	 * @return The rotation in degrees
	 */
	public abstract float getRotation();
	
	/**
	 * Sets the rotation of this {@link Shape} with its first point as the origin
	 * @param degrees The rotation in degrees
	 */
	public abstract void setRotation(float degrees);
	
	/**
	 * Sets the rotation of this {@link Shape} with a specified point as the origin
	 * @param originX The origin/center x coordinate
	 * @param originY The origin/center y coordinate
	 * @param degrees The rotation in degrees
	 */
	public abstract void setRotationAround(float originX, float originY, float degrees);
	
	/**
	 * Rotates this {@link Shape} by a specified amount of degrees with its first point as the origin
	 * @param degrees The rotation in degrees
	 */
	public abstract void rotate(float degrees);
	
	/**
	 * Rotates this {@link Shape} by a specified amount of degrees around a specified point
	 * @param originX The origin/center x coordinate
	 * @param originY The origin/center y coordinate
	 * @param degrees The rotation in degrees
	 */
	public abstract void rotateAround(float originX, float originY, float degrees);
	
	/**
	 * Returns the rotational center/origin x coordinate
	 * @return
	 */
	public abstract float getOriginX();
	
	/**
	 * Returns the rotational center/origin y coordinate
	 * @return
	 */
	public abstract float getOriginY();

	/**
	 * Draws this shape using a {@link Graphics} instance
	 * 
	 * @param g
	 *            The {@link Graphics} context to render with
	 */
	public abstract void draw(Graphics g);

	/**
	 * Fills this shape using a {@link Graphics} instance
	 * 
	 * @param g
	 *            The {@link Graphics} context to render with
	 */
	public abstract void fill(Graphics g);

	/**
	 * Returns the x coordinate of this object
	 * 
	 * @return 0 by default
	 */
	public abstract float getX();

	/**
	 * Returns the y coordinate of this object
	 * 
	 * @return 0 by default
	 */
	public abstract float getY();

	/**
	 * Sets the x coordinate of this object
	 * 
	 * @param x
	 *            The x coordinate
	 */
	public abstract void setX(float x);

	/**
	 * Sets the y coordinate of this object
	 * 
	 * @param y
	 *            The y coordinate
	 */
	public abstract void setY(float y);

	/**
	 * Sets the x and y coordinate of this object
	 * 
	 * @param x
	 *            The x coordinate
	 * @param y
	 *            The y coordinate
	 */
	public abstract void set(float x, float y);
	
	/**
	 * Returns the left-most x coordinate
	 * @return
	 */
	public abstract float getMinX();
	
	/**
	 * Returns the top-most y coordinate
	 * @return
	 */
	public abstract float getMinY();
	
	/**
	 * Returns the right-most x coordinate
	 * @return
	 */
	public abstract float getMaxX();
	
	/**
	 * Returns the bottom-most y coordinate
	 * @return
	 */
	public abstract float getMaxY();

	/**
	 * Translates the x and y coordinate of this object
	 * 
	 * @param translateX
	 *            The x translation amount
	 * @param translateY
	 *            The y translation amount
	 */
	public abstract void translate(float translateX, float translateY);

	/**
	 * Returns the number of edges of this object
	 * 
	 * @return The number of sides/edges
	 */
	public abstract int getNumberOfSides();

	/**
	 * Returns an {@link EdgeIterator} for looping over the edges of this
	 * {@link Shape}
	 * 
	 * @return The {@link EdgeIterator}
	 */
	public abstract EdgeIterator edgeIterator();
	
	/**
	 * Returns if this {@link Shape} is a {@link Circle}
	 * @return True if this {@link Shape} is a {@link Circle}
	 */
	public abstract boolean isCircle();
	
	/**
	 * Returns the {@link Polygon} representing this {@link Shape}
	 * @return Null if this {@link Shape} is a {@link Circle}
	 */
	public abstract Polygon getPolygon();
}
