/**
 * Copyright � 2002 The JA-SIG Collaborative.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 *    "This product includes software developed by the JA-SIG Collaborative
 *    (http://www.jasig.org/)."
 *
 * THIS SOFTWARE IS PROVIDED BY THE JA-SIG COLLABORATIVE "AS IS" AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE JA-SIG COLLABORATIVE OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package org.jasig.portal;

import org.jasig.portal.security.IPerson;
import org.w3c.dom.*;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface defining how the portal discovers it's channels and categories.
 * Methods are also provided to allow for publishing and unpublishing content.
 * @author Ken Weiner, kweiner@interactivebusiness.com
 * @version $Revision$
 */
public interface IChannelRegistryStore {

  /**
   * Get a channel definition.
   * @param channelPublishId a channel publish ID
   * @return channelDefinition, a definition of the channel
   * @throws java.lang.Exception
   */
  public ChannelDefinition getChannelDefinition(int channelPublishId) throws Exception;

  /**
   * Publishes a channel.
   * @param id the identifier for the channel
   * @param publisher the user who is publishing this channel
   * @param chanXML XML that describes the channel
   * @param catID an array of category IDs
   * @exception Exception
   */
  /*
  public void addChannelDefinition (ChannelDefinition channelDef, ChannelCategory[] categories, IPerson publisher) throws Exception;
  */

  /**
   * Permanently deletes a channel definition from the store.
   * @param channelPublishId a channel publish ID
   * @throws java.lang.Exception
   */
  public void deleteChannelDefinition(int channelPublishId) throws Exception;

  /**
   * Sets a channel definition as "approved".  This effectively makes a
   * channel definition available in the channel registry, making the channel
   * available for subscription.
   * @param channelPublishId a channel publish ID
   * @param approver the user that approves this channel definition
   * @param approveDate the date when the channel definition should be approved (can be future dated)
   * @throws java.lang.Exception
   */
  public void approveChannelDefinition(int channelPublishId, IPerson approver, Date approveDate) throws Exception;


  /**
   * Sets a channel definition as "unapproved".  This effectively removes a
   * channel definition from the channel registry, making the channel
   * unavailable for subscription.
   * @param channelPublishId a channel publish ID
   * @throws java.lang.Exception
   */
  public void disapproveChannelDefinition (String channelPublishId) throws Exception;

  /**
   * Registers a channel type.
   * @param chanType a channel type
   * @throws java.lang.Exception
   */
  public void addChannelType (ChannelType chanType) throws Exception;


  /**
   * Returns an array of ChannelTypes.
   * @return channelTypes, the list of publishable channel types
   * @throws java.lang.Exception
   */
  public ChannelType[] getChannelTypes() throws Exception;

}







