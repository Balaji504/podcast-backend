from . import *

class ClearListeningHistoryController(AppDevController):

  def get_path(self):
    return '/history/listening/clear/'

  def get_methods(self):
    return ['DELETE']

  @authorize
  def content(self, **kwargs):
    user = kwargs.get('user')
    listening_histories_dao.clear_listening_history(user)
    app.logger.info(
        '(id: %s, username: %s) listening history cleared',
        user.id, user.username
    )
    return dict()
