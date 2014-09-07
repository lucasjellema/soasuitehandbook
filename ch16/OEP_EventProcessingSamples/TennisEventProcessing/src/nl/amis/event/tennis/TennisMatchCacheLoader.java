package nl.amis.event.tennis;

import com.bea.cache.jcache.CacheLoader;
import com.bea.wlevs.ede.api.EventType;
import com.bea.wlevs.ede.api.EventTypeRepository;
import com.bea.wlevs.util.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

public class TennisMatchCacheLoader implements CacheLoader<String, Object>, InitializingBean {
    public TennisMatchCacheLoader() {
        super();
    }
  
    private Map<String, Object> matchesMap = new HashMap<String, Object>();
    private EventTypeRepository m_etr;

   

    @Service
    public void setEventTypeRepository(EventTypeRepository etr) {
        m_etr = etr;
    }


    @Override
    public Object load(String matchIdentifier) {
        return matchesMap.get(matchIdentifier);
    }

    @Override
    public Map<String, Object> loadAll(Collection<String> keysCollection) {
        Map<String, Object> retVal = new HashMap<String, Object>();
        for (String akey : keysCollection) {
            Object value = matchesMap.get(akey);
            if (value != null)
                retVal.put(akey, value);
        }

        return retVal;
    }

    @Override
    public Map<String, Object> loadAll() {
        return new HashMap<String, Object>(matchesMap);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //        // create events and load them into memory
        //        EventType eventType = getEventType();
        //        EventProperty matchIdProperty = eventType.getProperty("matchId");
        //
        //        Object event = eventType.createEvent();
        //        matchIdProperty.setValue(event, 0);
        matchesMap.put("0", new TennisMatch("0", "Nadal", "Federer"));
        matchesMap.put("1", new TennisMatch("1", "Jellema", "Edberg"));
        matchesMap.put("2", new TennisMatch("2", "McEnroe", "Djokovic"));
        matchesMap.put("3", new TennisMatch("3", "Sjarapova", "Williams"));


    }

   
}
