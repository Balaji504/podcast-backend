package podcast.controllers;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import podcast.models.entities.Person;
import podcast.models.entities.User;
import podcast.models.formats.Failure;
import podcast.models.formats.Result;
import podcast.models.formats.Success;
import podcast.services.GoogleService;
import podcast.services.UsersService;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import static podcast.models.utils.Constants.*;


/**
 * Users REST API controller
 */
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

  private final GoogleService googleService;
  private final UsersService usersService;

  @Autowired
  public UsersController(GoogleService googleService,
                         UsersService usersService) {
    this.googleService = googleService;
    this.usersService = usersService;
  }


  /** Google Sign In endpoint **/
  @RequestMapping(method = RequestMethod.POST, value = "/google_sign_in")
  public ResponseEntity<Result> googleSignIn(@RequestParam(value="id_token") String idToken) {
    try {
      /* Grab Google API response */
      JsonNode response = googleService.googleAuthentication(idToken);
      String googleID = googleService.googleIDFromResponse(response);

      /* Check if user exists */
      Optional<User> possUser = usersService.getUserByGoogleId(googleID);

      /* If exists, return, else make new user */
      Success r;
      if (possUser.isPresent()) {
        r = new Success(USER, possUser.get());
        r.addField(NEW_USER, false);
        return ResponseEntity.status(200).body(r);
      } else {
        User user = usersService.createUser(response);
        r = new Success(USER, user);
        r.addField(NEW_USER, true);
        return ResponseEntity.status(200).body(r);
      }
    } catch (Exception e) {
      return ResponseEntity.status(400).body(new Failure(e.getMessage()));
    }
  }


  /** Change username **/
  @RequestMapping(method = RequestMethod.POST, value = "/change_username")
  public ResponseEntity<Result> changeUsername(HttpServletRequest request,
                                               @RequestParam(value="username") String username) {
    /* Grab the user corresponding to the request */
    User user = (User) request.getAttribute(USER);

    try {
      usersService.updateUsername(user, username);
      return ResponseEntity.status(200).body(
        new Success(USER, user));
    } catch (Exception e) {
      return ResponseEntity.status(400).body(new Failure(e.getMessage()));
    }
  }


  /** Get a user by Id **/
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Result> userById(HttpServletRequest request,
                                         @PathVariable("id") String id) {
    /* Grab the user corresponding to the request */
    User user = (User) request.getAttribute(USER);
    try {
      if (user.getId().equals(id)) {
        return ResponseEntity.status(200).body(new Success(USER, user));
      } else {
        Person peer = new Person(usersService.getUserById(id));
        return ResponseEntity.status(200).body(new Success(USER, peer));
      }
    } catch (Exception e) {
      return ResponseEntity.status(400).body(new Failure(e.getMessage()));
    }
  }


}
