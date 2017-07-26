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
import projecteuler.problems.Problem1;

/**
 *
 * @author tyler.garavaglia
 */
public class ProjectEuler {

    private static final int TOTAL_PROBLEMS = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // simple(ish) CLI to display problems

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

        switch (probNumber) {
            case 1:
                new Problem1().execute();
                break;
            default:
                System.out.println("ERROR: You shouldn't get here. Quitting...");
                System.exit(1);
        }

    }

}
