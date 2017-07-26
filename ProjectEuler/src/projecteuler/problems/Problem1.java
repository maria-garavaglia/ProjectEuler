/*
 * Copyright (C) 2017 tyler.garavaglia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package projecteuler.problems;

/**
 * @Number: 1
 * @Title: Multiples of 3 and 5
 * @Description: "If we list all the natural numbers below 10 that are multiples
 * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the
 * sum of all the multiples of 3 or 5 below 1000."
 * @Link: https://projecteuler.net/problem=1
 *
 * @author tyler.garavaglia
 */
public class Problem1 implements EulerSolvable {

    public Problem1() {

    }

    @Override
    public void printHeader() {
        System.out.println("Problem 1: Multiples of 3 and 5");
        System.out.println("Task: Find the sum of all the multiples of 3 or 5 below 1000");
    }

    @Override
    public void execute() {
        int sum = 0;

        for (int count = 1; count < 1000; count++) {
            if (count % 3 == 0 || count % 5 == 0) {
                sum += count;
            }
        }

        System.out.println("Result: " + sum);
    }
}
