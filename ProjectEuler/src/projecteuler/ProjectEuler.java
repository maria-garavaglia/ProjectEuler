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
package projecteuler;

import java.util.InputMismatchException;
import java.util.Scanner;
import projecteuler.problems.EulerSolvable;
import projecteuler.problems.Problem1;
import projecteuler.problems.Problem2;

/**
 *
 * @author tyler.garavaglia
 */
public class ProjectEuler {

    private static final int TOTAL_PROBLEMS = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // simple(ish) CLI to display problems
        if (args.length > 0) {
            int probNumber = -1;
            try {
                probNumber = Integer.parseInt(args[0]);
            } catch (NumberFormatException ex) {
                System.out.print("ERROR: Non-integer argument given.");
                System.exit(1);
            }

            EulerSolvable problem = getProblem(probNumber);
            if (problem != null) {
                problem.printHeader();
                problem.execute();
            }
        } else {

            Scanner sysIn = new Scanner(System.in);

            boolean validNumber = false;
            int probNumber = -1;
            while (!validNumber) {
                System.out.print("Enter a problem number, or 0 to quit: ");

                try {
                    if (sysIn.hasNext()) {
                        probNumber = sysIn.nextInt();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR: Not a number.");
                    sysIn.nextLine();
                    continue;
                }

                // Quit early
                if (probNumber == 0) {
                    System.out.println("Quitting...");
                    System.exit(0);
                }

                if (probNumber > 0 && probNumber <= TOTAL_PROBLEMS) {
                    validNumber = true;
                } else {
                    System.out.println("ERROR: That problem hasn't been solved yet.");
                }
            }

            EulerSolvable problem = getProblem(probNumber);
            if (problem != null) {
                problem.printHeader();
                problem.execute();
            }
        }
    }

    public static EulerSolvable getProblem(int probNumber) {
        switch (probNumber) {
            case 1:
                return new Problem1();
            case 2:
                return new Problem2();
            default:
                System.out.println("ERROR: You shouldn't get here.");
                return null;
        }
    }
}
