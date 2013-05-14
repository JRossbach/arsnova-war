/*
 * Copyright (C) 2012 THM webMedia
 *
 * This file is part of ARSnova.
 *
 * ARSnova is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ARSnova is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.thm.arsnova.services;

import java.util.Map;
import java.util.Set;

import de.thm.arsnova.entities.Feedback;
import de.thm.arsnova.entities.User;

public interface IFeedbackService {
	void resetStorage();
	
	void cleanFeedbackVotes();

	Feedback getFeedback(String keyword);

	int getFeedbackCount(String keyword);

	double getAverageFeedback(String sessionkey);

	long getAverageFeedbackRounded(String sessionkey);

	boolean saveFeedback(String keyword, int value, User user);

	void broadcastFeedbackChanges(Map<String, Set<String>> affectedUsers, Set<String> allAffectedSessions);

	Integer getMyFeedback(String keyword, User user);
}
