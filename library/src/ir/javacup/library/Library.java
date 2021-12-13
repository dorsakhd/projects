package ir.javacup.library;

public class Library {
    private Member[] members;
    private final int capacity;
    private IdGenerator idGenerator;

    public Library(int capacity, IdGenerator idGenerator) {
        this.capacity = capacity;
        this.members = new Member[capacity];
        this.idGenerator = idGenerator;
    }

    public void register(Member member) throws LibraryFullException {
        if (isFull() == true) {
            throw new LibraryFullException("Library is full");
        } else
            for (int i = 0; i < capacity; i++) {
                if (members[i] == null) {
                    if (member != null) {
                        if (member.getLastName() != null) {
                            if (member.getFirstName() != null) {
                                members[i] = member;
                                member.setId(idGenerator.generate());
                                break;
                            } else throw new IllegalArgumentException("member.FirstName is null");
                        } else throw new IllegalArgumentException("member.LastName is null");
                    } else throw new IllegalArgumentException("member is null");
                }
            }
    }

    public Member unregister(int id){
        for (int i = 0; i < capacity; i++) {
            if (members[i].getId() == id) {
                Member member = members[i];
                members[i] = null;
                return member;
            }
        }
        throw new MemberNotFoundException("No member found with the given id");
    }

    public int getMemberCount() {
        int a = 0;
        for (int i = 0; i < capacity; i++) {
            if (members[i] != null) {
                a++;
            }
        } return a;
    }


    public boolean isFull() {
        for (int i = 0; i <capacity ; i++) {
            if(members[i]!=null){
                return false;
            }
        } return true;
    }

    public Member[] getMembers() {
        return members;
    }

    public int getCapacity() {
        return capacity;
    }
}
