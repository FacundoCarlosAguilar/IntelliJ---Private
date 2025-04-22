import java.util.Scanner;

public class ListaDoblemente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Playlist playlist = new Playlist();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "PUSH_BACK":
                    playlist.pushBack(Integer.parseInt(command[1]), command[2]);
                    break;
                case "PUSH_FRONT":
                    playlist.pushFront(Integer.parseInt(command[1]), command[2]);
                    break;
                case "INSERT":
                    playlist.insert(Integer.parseInt(command[1]), command[2]);
                    break;
                case "DELETE":
                    playlist.delete(Integer.parseInt(command[1]));
                    break;
                case "NEXT":
                    playlist.next();
                    break;
                case "PREV":
                    playlist.prev();
                    break;
                case "PLAY":
                    System.out.println(playlist.play());
                    break;
                case "PRINT_ALL":
                    System.out.println(playlist.printAll());
                    break;
            }
        }

        scanner.close();
    }

    static class Playlist {
        private Song head;
        private Song tail;
        private Song current;

        public void pushBack(int id, String name) {
            Song newSong = new Song(id, name);
            if (head == null) {
                head = tail = current = newSong;
            } else {
                tail.next = newSong;
                newSong.prev = tail;
                tail = newSong;
            }
        }

        public void pushFront(int id, String name) {
            Song newSong = new Song(id, name);
            if (head == null) {
                head = tail = current = newSong;
            } else {
                newSong.next = head;
                head.prev = newSong;
                head = newSong;
            }
        }

        public void insert(int id, String name) {
            if (current == null) {
                pushBack(id, name);
                return;
            }
            Song newSong = new Song(id, name);
            newSong.next = current;
            newSong.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newSong;
            } else {
                head = newSong;
            }
            current.prev = newSong;
        }

        public void delete(int id) {
            Song temp = head;
            while (temp != null && temp.id != id) {
                temp = temp.next;
            }
            if (temp == null) return;

            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next;
            }

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev;
            }

            if (current == temp) {
                current = temp.next != null ? temp.next : head;
            }
        }

        public void next() {
            current = (current != null && current.next != null) ? current.next : head;
        }

        public void prev() {
            current = (current != null && current.prev != null) ? current.prev : tail;
        }

        public String play() {
            return current != null ? current.name : "No song";
        }

        public String printAll() {
            StringBuilder sb = new StringBuilder();
            Song temp = head;
            while (temp != null) {
                sb.append(temp.name).append(" ");
                temp = temp.next;
            }
            return sb.toString().trim();
        }
    }

    static class Song {
        int id;
        String name;
        Song next;
        Song prev;

        public Song(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
