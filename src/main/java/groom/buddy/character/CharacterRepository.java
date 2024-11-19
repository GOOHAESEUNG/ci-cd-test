package groom.buddy.character;

import groom.buddy.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {


}