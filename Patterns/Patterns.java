package Patterns;

public class Patterns {
    int n;

    public Patterns(int n) {
        this.n = n;
    }

    public void starPyramid() {
        System.out.println("Star Paramyd");

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n * 2 - 1; j = j + 1) {
                if (j >= (n - i - 1) && j < (n * 2 - (n - i))) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }

    public void invertedStarPyramid() {

        for (int i = this.n - 1; i >= 0; i--) {
            for (int j = 0; j < this.n * 2 - 1; j = j + 1) {
                if (j >= (n - i - 1) && j < (n * 2 - (n - i))) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }

    }

    public void diamondStarProblem() {
        for (int i = 0; i < this.n * 2; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                if (i < n) {
                    if (j >= (n - i - 1) && j <= (n * 2 - (n - i) - 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(".");
                    }
                } else {
                    // System.out.print("*");
                    if (j >= (i - n) && j < (2 * n - (i - n) - 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(".");
                    }
                }

            }
            System.out.println(" ");

        }
    }

    public void halfDiamondStarPattern() {
        for (int i = 0; i < this.n * 2 - 1; i++) {
            for (int j = 0; j <= this.n; j++) {
                if (i < n) {
                    if (j <= i) {
                        System.out.print("*");
                    }
                } else {
                    if (j < (2 * n - i - 1)) {
                        System.out.print("*");
                    }
                }
            }
            System.out.println(" ");

        }
    }

    public void binaryNumberTrianglePattern() {
        for (int i = 0; i < this.n; i++) {
            // for (int j = 0; j <= i; j++) {
            // int value = (i + j + 1) % 2;
            // System.out.print(value + " ");
            // }
            // System.out.println(" ");

            int start = 1;

            if (i % 2 == 1)
                start = 0;

            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }

    }

    public void numberCrownPattern() {
        for (int i = 1; i < this.n; i++) {

            for (int j = 1; j < this.n; j++) {
                if (j <= i)
                    System.out.print(j);
                else
                    System.out.print(" ");
            }
            for (int j = this.n - 1; j > 0; j--) {
                if (j <= i)
                    System.out.print(j);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void increasingNumberTrianglePattern() {
        int number = 1;

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }

    }

    public void increasingLetterTrianglePattern() {

        for (int i = 0; i < this.n; i++) {
            char character = 'A';

            for (int j = 0; j <= i; j++) {
                System.out.print(character + " ");
                character++;
            }
            System.out.println("");
        }

    }

    public void reverseLetterTrianglePattern() {

        for (int i = 0; i < this.n; i++) {
            char character = 'A';

            for (int j = 0; j < n - i; j++) {
                System.out.print(character + " ");
                character++;
            }
            System.out.println("");
        }

    }

    public void alphaRampPattern() {
        char character = 'A';

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(character + " ");
            }
            character++;
            System.out.println("");
        }

    }

    public void alphaHillPattern() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            char character = 'A';
            for (; character < 'A' + i + 1; character++) {
                System.out.print(character);
            }
            character--;
            character--;
            for (; character >= 'A'; character--) {
                System.out.print(character);

            }
            System.out.println();

        }
    }

    public void alphaTrianglePattern() {
        for (int i = 0; i < this.n; i++) {
            char c = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (c + (n - i - 1) + j) + " ");
            }
            System.out.println();
        }
    }

    public void symmetricVoidPattern() {
        for (int i = 0; i < this.n * 2; i++) {
            for (int j = 0; j < this.n * 2; j++) {
                if (i < n)
                    if (j < (this.n - i) || j >= (this.n * 2 - (this.n - i))) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                else {
                    if (j <= (i - this.n) || j >= (this.n * 2 - (i - this.n + 1))) {
                        System.out.print("*");

                    } else {
                        System.out.print(" ");
                    }

                }
            }
            System.err.println();
        }

    }

    public void symmetricButterflyPattern() {
        int str = 2 * this.n - 2;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < str; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            str -= 2;
        }
        str = 2;
        for (int i = 1; i < this.n; i++) {
            for (int j = 0; j < (n - i); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < str; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n - i); j++) {
                System.out.print("*");
            }

            System.out.println("");
            str += 2;
        }
    }

    public void hollowRectanglePattern() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (j == 0 || i == 0 || j == this.n - 1 || i == this.n - 1)
                    System.out.print("*");
                else
                    System.err.print(" ");

            }
            System.err.println("");
        }
    }

    public void theNumberPattern() {
        for (int i = 0; i < this.n * 2 - 1; i++) {
            for (int j = 0; j < this.n * 2 - 1; j++) {
                int left = j;
                int top = i;

                int right = (this.n * 2 - 2) - j;
                int bottom = (this.n * 2 - 2) - i;
                System.out.print(n - Math.min(Math.min(left, right), Math.min(top, bottom)) + " ");

            }
            System.out.println();
        }
    }

}
